package com.sites.service;

import com.sites.controller.models.SiteRawData;
import com.sites.controller.models.SiteRawDataSummary;
import com.sites.persistence.entities.SiteRawDataEntity;
import com.sites.persistence.repositories.SiteRawDataRepository;
import com.sites.service.domain.filter.FilterCriteria;
import com.sites.service.domain.filter.NumberFilterCriteria;
import com.sites.service.domain.filter.NumberFilterOperationEnum;
import com.sites.util.mapper.MapperHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SiteRawDataServiceTest {
    @Mock
    private SiteRawDataRepository siteRawDataRepository;
    @InjectMocks
    private SiteRawDataService siteRawDataService;

    private List<SiteRawDataEntity> siteRawDataEntityList;

    @Before
    public void setUp() {

        siteRawDataEntityList = new ArrayList<>();
        SiteRawDataEntity siteRawData1 = new SiteRawDataEntity();
        siteRawData1.setId("proj-01");
        siteRawData1.setProjectName("project1");
        siteRawData1.setTopicTitle("test topic 1");
        siteRawData1.setSubProject("subProject1");
        siteRawData1.setDomainAuthority(1);
        siteRawData1.setSiteTraffic(100L);
        siteRawData1.setMentionType("link");
        siteRawData1.setCommercialLink("yes");
        siteRawData1.setMentionAcquisition("paid");
        siteRawData1.setFollowType("follow");
        siteRawData1.setSiteType("media");

        SiteRawDataEntity siteRawData2 = new SiteRawDataEntity();
        siteRawData1.setId("proj-02");
        siteRawData2.setProjectName("project");
        siteRawData2.setTopicTitle("test topic 2");
        siteRawData2.setSubProject("subProject");
        siteRawData2.setDomainAuthority(90);
        siteRawData2.setSiteTraffic(10000L);
        siteRawData2.setMentionType("link");
        siteRawData2.setCommercialLink("no");
        siteRawData2.setMentionAcquisition("paid");
        siteRawData2.setFollowType("follow");
        siteRawData2.setSiteType("media");

        siteRawDataEntityList.add(siteRawData1);
        siteRawDataEntityList.add(siteRawData2);
    }

    @Test
    public void whenFindSiteRawDataByCriteria() {
        FilterCriteria searchCriteria =
                new NumberFilterCriteria(NumberFilterOperationEnum.EQUALS, 1, "clientId");

        List<FilterCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(searchCriteria);

        Pageable page = PageRequest.of(0, 5);
        Page<SiteRawDataEntity> expectedPages = new PageImpl<>(siteRawDataEntityList, page, 1);
        Specification<SiteRawDataEntity> specification = searchCriteria.specification();
        when(siteRawDataRepository.findAll(specification, page)).thenReturn(expectedPages);

        List<SiteRawData> expectedList = new ArrayList<>();
        siteRawDataEntityList.forEach(e -> expectedList.add(MapperHelper.SITE_DATA_MAPPER.convertToSiteRawData(e)));

        Page<SiteRawData> resultPage = siteRawDataService.findSiteRawDataByCriteria(criteriaList, page);
        List<SiteRawData> resultList = resultPage.getContent();

        Assert.assertEquals(expectedList.size(), resultList.size());

        for(int i=0; i<expectedList.size(); i++) {
            SiteRawData expectedSite = expectedList.get(i);
            SiteRawData resultSite = resultList.get(i);
            Assert.assertEquals(expectedSite, resultSite);
        }
    }

    @Test
    public void whenFindSiteRawDataByCriteriaAndExpectEmptyPage() {
        FilterCriteria searchCriteria =
                new NumberFilterCriteria(NumberFilterOperationEnum.EQUALS, 1, "clientId");

        List<FilterCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(searchCriteria);
        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = searchCriteria.specification();
        Page<SiteRawDataEntity> expectedPages = new PageImpl<>(new ArrayList<>(), page, 1);

        when(siteRawDataRepository.findAll(specification, page)).thenReturn(expectedPages);

        Page<SiteRawData> resultPage = siteRawDataService.findSiteRawDataByCriteria(criteriaList, page);
        List<SiteRawData> resultList = resultPage.getContent();
        Assert.assertTrue(resultList.isEmpty());
    }

    @Test
    public void whenFindSiteRawData() {
        Pageable page = PageRequest.of(0, 5);
        Page<SiteRawDataEntity> expectedPages = new PageImpl<>(siteRawDataEntityList, page, 1);

        when(siteRawDataRepository.findAll(page)).thenReturn(expectedPages);

        Page<SiteRawData> resultPage = siteRawDataService.findSiteRawData(page);
        List<SiteRawData> resultList = resultPage.getContent();
        List<SiteRawData> expectedList = new ArrayList<>();

        siteRawDataEntityList.forEach(e -> expectedList.add(MapperHelper.SITE_DATA_MAPPER.convertToSiteRawData(e)));

        Assert.assertEquals(expectedList.size(), resultList.size());

        for(int i=0; i<expectedList.size(); i++) {
            SiteRawData expectedSite = expectedList.iterator().next();
            SiteRawData resultSite = resultList.iterator().next();
            Assert.assertEquals(expectedSite, resultSite);
        }
    }

    @Test
    public void whenFindSiteRawDataAndExpectEmptyPage() {
        Pageable page = PageRequest.of(0, 5);
        Page<SiteRawDataEntity> expectedPages = new PageImpl<>(new ArrayList<>(), page, 1);

        when(siteRawDataRepository.findAll(page)).thenReturn(expectedPages);

        Page<SiteRawData> resultPage = siteRawDataService.findSiteRawData(page);
        List<SiteRawData> resultList = resultPage.getContent();

        Assert.assertTrue(resultList.isEmpty());
    }

    @Test
    public void whenFindSiteRawDataSummary() {
        Pageable page = PageRequest.of(0, 5);
        Page<SiteRawDataEntity> expectedPages = new PageImpl<>(siteRawDataEntityList, page, 1);

        when(siteRawDataRepository.findAll(page)).thenReturn(expectedPages);

        Page<SiteRawDataSummary> resultPage = siteRawDataService.findSiteRawDataSummary(page);
        List<SiteRawDataSummary> resultList = resultPage.getContent();

        List<SiteRawDataSummary> expectedList = new ArrayList<>();
        siteRawDataEntityList.forEach(
                e -> expectedList.add(MapperHelper.SITE_DATA_MAPPER.convertToSiteRawDataSummary(e)));

        Assert.assertEquals(expectedList.size(), resultList.size());

        for(int i=0; i<expectedList.size(); i++) {
            SiteRawDataSummary expectedSite = expectedList.iterator().next();
            SiteRawDataSummary resultSite = resultList.iterator().next();
            Assert.assertEquals(expectedSite, resultSite);
        }
    }

    @Test
    public void whenFindSiteRawDataSummaryAndExpectEmptyPage() {
        Pageable page = PageRequest.of(0, 5);
        Page<SiteRawDataEntity> expectedPages = new PageImpl<>(new ArrayList<>(), page, 1);

        when(siteRawDataRepository.findAll(page)).thenReturn(expectedPages);

        Page<SiteRawDataSummary> resultPage = siteRawDataService.findSiteRawDataSummary(page);
        List<SiteRawDataSummary> resultList = resultPage.getContent();

        Assert.assertTrue(resultList.isEmpty());
    }
}
