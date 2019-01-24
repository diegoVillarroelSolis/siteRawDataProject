package com.sites.persistence;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.sites.persistence.entities.SiteRawDataEntity;
import com.sites.persistence.repositories.SiteRawDataRepository;
import com.sites.service.domain.filter.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@SpringBootTest
public class SiteRawDataRepositoryTest {

    @Autowired
    private SiteRawDataRepository siteRawDataRepository;

    @Test
    public void whenFindAllWithNumberEqualFilterOperation() throws Exception {
        FilterCriteria searchCriteria =
                new NumberFilterCriteria(NumberFilterOperationEnum.EQUALS, 4, "clientId");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = searchCriteria.specification();
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(50, siteRawDataEntityPage.getTotalPages());
        assertEquals(5, siteRawDataEntityPage.getContent().size());
    }

    @Test
    public void whenFindAllWithStringEqualsFilterOperation() throws Exception {
        FilterCriteria searchCriteria =
                new StringFilterCriteria(StringFilterOperationEnum.EQUALS, "ad-hoc", "projectName");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = searchCriteria.specification();
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(7, siteRawDataEntityPage.getTotalPages());
        assertEquals(5, siteRawDataEntityPage.getContent().size());
    }

    @Test
    public void whenFindAllWithStringContainsFilterOperation() throws Exception {
        FilterCriteria searchCriteria =
                new StringFilterCriteria(StringFilterOperationEnum.CONTAINS, "hoc", "projectName");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = searchCriteria.specification();
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(7, siteRawDataEntityPage.getTotalPages());
        assertEquals(5, siteRawDataEntityPage.getContent().size());
    }

    @Test
    public void whenFindAllWithStringIgnoreCaseFilterOperation() throws Exception {
        FilterCriteria searchCriteria =
                new StringFilterCriteria(
                        StringFilterOperationEnum.EQUALS_IGNORE_CASE,
                        "jurassic park",
                        "projectName");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = searchCriteria.specification();
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(2, siteRawDataEntityPage.getTotalPages());
        assertEquals(5, siteRawDataEntityPage.getContent().size());
    }

    @Test
    public void whenFindAllWithDateEqualFilterOperation() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse ( "2018-10-01" );
        FilterCriteria criteria1 =
                new DateFilterCriteria(DateFilterOperationEnum.EQUALS, date, null, "dateFound");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = criteria1.specification();
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(1, siteRawDataEntityPage.getTotalPages());
        assertEquals(2, siteRawDataEntityPage.getContent().size());
    }

    @Test
    public void whenFindAllWithDateMonthAndYearFilterOperation() throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2018);
        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        c.set(Calendar.DAY_OF_MONTH, 9);
        Date date = c.getTime();

        FilterCriteria criteria1 =
                new DateFilterCriteria(DateFilterOperationEnum.MONTH, date, null, "dateFound");
        FilterCriteria criteria2 =
                new DateFilterCriteria(DateFilterOperationEnum.YEAR, date, null, "dateFound");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = criteria1.specification();
        specification = Specification.where(specification).and(criteria2.specification());
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(10, siteRawDataEntityPage.getTotalPages());
        assertEquals(5, siteRawDataEntityPage.getContent().size());
    }

    @Test
    public void whenFindAllWithDateRangeFilterOperation() throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2018);
        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        c.set(Calendar.DAY_OF_MONTH, 9);
        Date date1 = c.getTime();
        c.set(Calendar.YEAR, 2019);
        Date date2 = c.getTime();

        FilterCriteria criteria1 =
                new DateFilterCriteria(DateFilterOperationEnum.RANGE, date1, date2, "dateFound");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = criteria1.specification();
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(26, siteRawDataEntityPage.getTotalPages());
        assertEquals(5, siteRawDataEntityPage.getContent().size());
    }

    @Test
    public void whenFindAllWithNumberStringAndDateSpecification() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse ( "2018-10-01" );

        FilterCriteria criteria1 =
                new NumberFilterCriteria(NumberFilterOperationEnum.EQUALS, 4, "clientId");
        FilterCriteria criteria2 =
                new StringFilterCriteria(StringFilterOperationEnum.EQUALS, "ad-hoc", "projectName");
        FilterCriteria criteria3 =
                new DateFilterCriteria(DateFilterOperationEnum.EQUALS, date, null, "dateFound");

        Pageable page = PageRequest.of(0, 5);
        Specification<SiteRawDataEntity> specification = criteria1.specification();
        specification = Specification.where(specification).and(criteria2.specification());
        specification = Specification.where(specification).and(criteria3.specification());
        Page<SiteRawDataEntity> siteRawDataEntityPage = siteRawDataRepository
                .findAll(specification, page);

        assertEquals(1, siteRawDataEntityPage.getTotalPages());
        assertEquals(1, siteRawDataEntityPage.getContent().size());
    }
}
