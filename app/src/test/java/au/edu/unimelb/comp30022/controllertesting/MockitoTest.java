package au.edu.unimelb.comp30022.controllertesting;

import org.mockito.Mockito;
import org.mockito.invocation.Location;

/**
 * Created by James on 6/09/2017.
 */

public class MockitoTest {
    AddressTools addressToolsMock = Mockito.mock(AddressTools.class);
    // create other mocks
    PostcodeValidator postcodeValidatorMock = Mockito.mock(PostcodeValidator.class);
    PostageRateCalculator postageRateCalculatorMock = Mockito.mock(PostageRateCalculator.class);

    // pass mock objects as dependency to constructor
    Controller controller = new Controller(addressToolsMock, postcodeValidatorMock, postageRateCalculatorMock);

    // configure mock expected interation
    Mockito.when(postageRateCalculator.computeCost(any(Location.class), any(Location.class))).thenReturn(5);

    // call method being tested
    controller.calculateButtonPressed();


    // check if mock had expected interaction
    Mockito.verify(postageRateCalculator.computeCost(any(Location.class), any(Location.class)));

    // assert results
    assertEquals("$5",costLabel.getText());

}
