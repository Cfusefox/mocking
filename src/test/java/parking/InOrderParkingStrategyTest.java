package parking;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InOrderParkingStrategyTest {

	@Test
    public void testCreateReceipt_givenACarAndAParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 1, Write a test case on InOrderParkingStrategy.createReceipt()
	    * With using Mockito to mock the input parameter */
        //given
        InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
        Car mockedCar = mock(Car.class);
        ParkingLot mockedParkingLot = mock(ParkingLot.class);
        when(mockedCar.getName()).thenReturn("car");
        when(mockedParkingLot.getName()).thenReturn("parkinglot");

        //when
        Receipt actual = inOrderParkingStrategy.createReceipt(mockedParkingLot, mockedCar);

        //then
        assertEquals("car", actual.getCarName());
        assertEquals("parkinglot", actual.getParkingLotName());
    }

    @Test
    public void testCreateNoSpaceReceipt_givenACar_thenGiveANoSpaceReceipt() {

        /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
         * With using Mockito to mock the input parameter */
        InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
        Car mockedCar = mock(Car.class);
        when(mockedCar.getName()).thenReturn("car");

        //when
        Receipt actual = inOrderParkingStrategy.createNoSpaceReceipt(mockedCar);

        //then
        assertEquals("car", actual.getCarName());
        assertEquals("No Parking Lot", actual.getParkingLotName());

    }

    @Test
    public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt(){

	    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for no available parking lot */
        //given
        InOrderParkingStrategy inOrderParkingStrategy = spy(new InOrderParkingStrategy());
        Car mockedCar = mock(Car.class);
        ParkingLot mockedParkingLot = mock(ParkingLot.class);
        when(mockedCar.getName()).thenReturn("car");
        when(mockedParkingLot.isFull()).thenReturn(true);

        //when
        inOrderParkingStrategy.park(Arrays.asList(mockedParkingLot), mockedCar);

        //then
        verify(inOrderParkingStrategy).createNoSpaceReceipt(mockedCar);

    }

    @Test
    public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot */

    }

    @Test
    public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot but it is full */

    }

    @Test
    public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot(){

        /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */

    }


}
