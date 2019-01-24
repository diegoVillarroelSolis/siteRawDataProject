package com.sites.controller;

import com.sites.controller.models.*;
import com.sites.service.SiteRawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "v1/siteRawData/")
public class SiteRawDataController {

    private SiteRawDataService siteRawDataService;

    @Autowired
    public SiteRawDataController(SiteRawDataService siteRawDataService) {
        this.siteRawDataService = siteRawDataService;
    }

    @GetMapping
    public ResponseEntity<SiteRawDataResponse> getSiteRawData(@RequestParam("page") int page,
                                                              @RequestParam("size") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<SiteRawData> siteRawData = siteRawDataService.findSiteRawData(pageRequest);
        ResponseEntity<SiteRawDataResponse> response =
                new ResponseEntity<>(new SiteRawDataResponse(), HttpStatus.NO_CONTENT);
        if( !siteRawData.isEmpty() ) {
            response = new ResponseEntity<>(new SiteRawDataResponse(
                        siteRawData.getContent(),
                        siteRawData.getTotalPages(),
                        siteRawData.getNumberOfElements()),
                    HttpStatus.OK);
        }
        return response;
    }

    @PostMapping(value = "search")
    public ResponseEntity<SiteRawDataResponse> searchSiteRawData(@Valid @RequestBody SearchRequest searchRequest,
                                                                 @RequestParam("page") int page,
                                                                 @RequestParam("size") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<SiteRawData> siteRawData =
                siteRawDataService.findSiteRawDataByCriteria(searchRequest.getFilterCriteriaList(), pageRequest);
        ResponseEntity<SiteRawDataResponse> response =
                new ResponseEntity<>(new SiteRawDataResponse(), HttpStatus.NO_CONTENT);
        if( !siteRawData.isEmpty() ) {
            response = new ResponseEntity<>(new SiteRawDataResponse(
                    siteRawData.getContent(),
                    siteRawData.getTotalPages(),
                    siteRawData.getNumberOfElements()),
                    HttpStatus.OK);
        }
        return response;
    }

    @GetMapping(value = "summary")
    public ResponseEntity<SiteRawDataSummaryResponse> getSiteRawDataSummary(@RequestParam("page") int page,
                                                                            @RequestParam("size") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<SiteRawDataSummary> siteRawData = siteRawDataService.findSiteRawDataSummary(pageRequest);
        ResponseEntity<SiteRawDataSummaryResponse> response =
                new ResponseEntity<>(new SiteRawDataSummaryResponse(), HttpStatus.NO_CONTENT);
        if( !siteRawData.isEmpty() ) {
            response = new ResponseEntity<>(new SiteRawDataSummaryResponse(
                    siteRawData.getContent(),
                    siteRawData.getTotalPages(),
                    siteRawData.getNumberOfElements()),
                    HttpStatus.OK);
        }
        return response;
    }
}
