package com.mentoring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ServiceTest {

    private final Service service = new Service();
    
    @Test
    public void sumTwoTest() {
        assertThat(service.sumTwo(2, 2)).isEqualTo(4);
    }
    
}
