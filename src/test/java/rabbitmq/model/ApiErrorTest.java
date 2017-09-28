package rabbitmq.model;

import org.junit.Test;
import rabbitmq.error.ErrorCategory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fotarik on 28/09/2017.
 */
public class ApiErrorTest {

    @Test
    public void testBuilder() {
        ApiError apiError = ApiError.builder().build();
        assertNotNull(apiError);
    }

    @Test
    public void testBuilderWithId() {
        ApiError apiError = ApiError.builder().id(1).build();
        assertNotNull(apiError);
        assertEquals(apiError.getId().intValue(),1);
    }

    @Test
    public void testBuilderWithErrorMessage() {
        ApiError apiError = ApiError.builder().message("Error").build();
        assertNotNull(apiError);
        assertEquals(apiError.getMessage(),"Error");
    }

    @Test
    public void testBuilderWithErrorCategory() {
        ApiError apiError = ApiError.builder().category(ErrorCategory.BUSINESS).build();
        assertNotNull(apiError);
        assertEquals(apiError.getCategory(),ErrorCategory.BUSINESS);
    }

    @Test
    public void testBuilderWithIdAndMessageAndErrorCategory() {
        ApiError apiError = ApiError.builder().id(1).message("Error").category(ErrorCategory.BUSINESS).build();
        assertNotNull(apiError);
        assertEquals(apiError.getId().intValue(),1);
        assertEquals(apiError.getMessage(),"Error");
        assertEquals(apiError.getCategory(),ErrorCategory.BUSINESS);
    }
}
