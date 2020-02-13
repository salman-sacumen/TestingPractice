package com;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CalculatorTest {

	@Rule public MockitoRule rule=MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

	@InjectMocks
    RecordService recordService;
	
	@Mock
    DatabaseDAO databaseMock;
	
	@Mock
    NetworkDAO networkMock;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void saveTest()
    {
        boolean saved = recordService.save("temp.txt");
        assertEquals(true, saved);
         
        verify(databaseMock, times(1)).save("temp.txt");
        verify(networkMock, times(1)).save("temp.txt");
    }
	
	
   
}
