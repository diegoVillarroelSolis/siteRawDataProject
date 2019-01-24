package com.sites.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sites.controller.models.*;
import com.sites.service.SiteRawDataService;
import com.sites.service.domain.filter.FilterCriteria;
import com.sites.service.domain.filter.NumberFilterCriteria;
import com.sites.service.domain.filter.NumberFilterOperationEnum;
import com.sites.util.mapper.MapperHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SiteRawDataController.class)
public class SiteRawDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SiteRawDataService siteRawDataService;

    private ObjectMapper mapper;

    private List<SiteRawData> siteRawDataExpectedList;

    @Before
    public void setUp() throws Exception {
        mapper = new ObjectMapper();

        siteRawDataExpectedList = new ArrayList<>();
        SiteRawData siteRawData1 = new SiteRawData();
        siteRawData1.setProjectName("project1");
        siteRawData1.setTopicTitle("test topic 1");
        siteRawData1.setSubProjectName("subProject1");
        siteRawData1.setDomainAuthority(1);
        siteRawData1.setSiteTraffic(100L);
        siteRawData1.setMentionType("link");
        siteRawData1.setCommercialLink("yes");
        siteRawData1.setMentionAcquisition("paid");
        siteRawData1.setFollowType("follow");
        siteRawData1.setSiteType("media");

        SiteRawData siteRawData2 = new SiteRawData();
        siteRawData2.setProjectName("project");
        siteRawData2.setTopicTitle("test topic 2");
        siteRawData2.setSubProjectName("subProject");
        siteRawData2.setDomainAuthority(90);
        siteRawData2.setSiteTraffic(10000L);
        siteRawData2.setMentionType("link");
        siteRawData2.setCommercialLink("no");
        siteRawData2.setMentionAcquisition("paid");
        siteRawData2.setFollowType("follow");
        siteRawData2.setSiteType("media");

        siteRawDataExpectedList.add(siteRawData1);
        siteRawDataExpectedList.add(siteRawData2);
    }

    @Test
    public void whenSearchSiteRawData() throws Exception {
        FilterCriteria filterCriteria =
                new NumberFilterCriteria(NumberFilterOperationEnum.EQUALS, 4, "clientId");

        List<FilterCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(filterCriteria);

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setFilterCriteriaList(criteriaList);

        PageRequest pageRequest = PageRequest.of(0,5);
        Page<SiteRawData> pagedResult = new PageImpl<>(siteRawDataExpectedList, pageRequest, 1);

        String searchRequestJson = mapper.writeValueAsString(searchRequest);
        when(siteRawDataService.findSiteRawDataByCriteria(
                    searchRequest.getFilterCriteriaList(),
                    pageRequest))
                .thenReturn(pagedResult);

        ResultActions resultActions = mockMvc.perform(post("/v1/siteRawData/search")
                        .param("page", "0")
                        .param("size", "5")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(searchRequestJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        SiteRawDataResponse siteRawDataResult = mapper.readValue(resultActions.andReturn()
                .getResponse()
                .getContentAsString(), SiteRawDataResponse.class);

        Assert.assertEquals(siteRawDataExpectedList.size(), siteRawDataResult.getSiteRawData().size());

        for(int i=0; i<siteRawDataResult.getSiteRawData().size(); i++) {
            SiteRawData expectedSite = siteRawDataExpectedList.get(i);
            SiteRawData resultSite = mapper.convertValue(siteRawDataResult.getSiteRawData().get(i), SiteRawData.class);
            Assert.assertEquals(expectedSite, resultSite);
        }
    }

    @Test
    public void whenSearchSiteRawDataAndExpectNoContent() throws Exception {
        FilterCriteria filterCriteria =
                new NumberFilterCriteria(NumberFilterOperationEnum.EQUALS, -1, "clientId");

        List<FilterCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(filterCriteria);

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setFilterCriteriaList(criteriaList);

        PageRequest pageRequest = PageRequest.of(0,5);
        Page<SiteRawData> pagedResult = new PageImpl<>(new ArrayList<>(), pageRequest, 1);

        when(siteRawDataService.findSiteRawDataByCriteria(
                    searchRequest.getFilterCriteriaList(), pageRequest))
                .thenReturn(pagedResult);

        String searchRequestJson = mapper.writeValueAsString(searchRequest);
        mockMvc.perform(post("/v1/siteRawData/search")
                    .param("page", "0")
                    .param("size", "5")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(searchRequestJson))
                .andExpect(status().isNoContent())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void whenGetAllSiteRawData() throws Exception {

        PageRequest pageRequest = PageRequest.of(0,5);
        Page<SiteRawData> siteRawDataExpected = new PageImpl<>(siteRawDataExpectedList, pageRequest, 1);

        when(siteRawDataService.findSiteRawData(pageRequest)).thenReturn(siteRawDataExpected);

        ResultActions resultActions = mockMvc.perform(get("/v1/siteRawData/")
                    .param("page", "0")
                    .param("size", "5")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        SiteRawDataResponse siteRawDataResult = mapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                SiteRawDataResponse.class);

        Assert.assertEquals(siteRawDataExpectedList.size(), siteRawDataResult.getSiteRawData().size());

        for(int i=0; i<siteRawDataResult.getSiteRawData().size(); i++) {
            SiteRawData expectedSite = siteRawDataExpected.getContent().get(i);
            SiteRawData resultSite = mapper.convertValue(siteRawDataResult.getSiteRawData().get(i), SiteRawData.class);
            Assert.assertEquals(expectedSite, resultSite);
        }
    }

    @Test
    public void whenGetAllSiteRawDataAndExpectNoContent() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,5);
        List<SiteRawData> expectedList = new ArrayList<>();

        Page<SiteRawData> siteRawDataExpected = new PageImpl<>(expectedList, pageRequest, 1);
        when(siteRawDataService.findSiteRawData(pageRequest)).thenReturn(siteRawDataExpected);

        mockMvc.perform(get("/v1/siteRawData/")
                    .param("page", "0")
                    .param("size", "5")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void whenGetSiteRawDataSummary() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,5);

        List<SiteRawDataSummary> expectedList = new ArrayList<>();
        siteRawDataExpectedList.forEach(
                e -> expectedList.add(MapperHelper.SITE_DATA_MAPPER.convertToSiteRawDataSummary(e)));

        Page<SiteRawDataSummary> expectedPage = new PageImpl<>(expectedList, pageRequest, 1);
        when(siteRawDataService.findSiteRawDataSummary(pageRequest)).thenReturn(expectedPage);

        ResultActions resultActions = mockMvc.perform(get("/v1/siteRawData/summary")
                .param("page", "0")
                .param("size", "5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        SiteRawDataSummaryResponse siteRawDataResult = mapper.readValue(resultActions.andReturn()
                .getResponse()
                .getContentAsString(), SiteRawDataSummaryResponse.class);

        Assert.assertEquals(expectedPage.getContent().size(), siteRawDataResult.getSiteRawDataSummary().size());

        for(int i=0; i<siteRawDataResult.getSiteRawDataSummary().size(); i++) {
            SiteRawDataSummary expectedSite = expectedPage.getContent().get(i);
            SiteRawDataSummary resultSite =
                    mapper.convertValue(siteRawDataResult.getSiteRawDataSummary().get(i), SiteRawDataSummary.class);
            Assert.assertEquals(expectedSite, resultSite);
        }
    }

    @Test
    public void whenGetSiteRawDataSummaryAndExpectNoContent() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,5);
        Page<SiteRawDataSummary> expectedPage = new PageImpl<>(new ArrayList<>(), pageRequest, 1);

        when(siteRawDataService.findSiteRawDataSummary(pageRequest)).thenReturn(expectedPage);

        mockMvc.perform(get("/v1/siteRawData/summary")
                .param("page", "0")
                .param("size", "5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}
