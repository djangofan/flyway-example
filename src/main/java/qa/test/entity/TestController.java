package qa.test.entity;

import qa.test.entity.News;
import qa.test.entity.persistence.EntityDao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Test
 */
@Named
@RequestScoped
public class TestController {

    @Inject
    EntityDao entityDao;

    @Produces
    @Named(value = "firstNews")
    @RequestScoped
    public News getNews() {
        return this.entityDao.find(News.class, (long) 1);
    }
}
