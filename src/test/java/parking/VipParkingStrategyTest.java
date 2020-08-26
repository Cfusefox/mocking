package parking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VipParkingStrategyTest {

    @Mock
    Car car;

    @Mock
    CarDao carDao;

    @InjectMocks
    VipParkingStrategy vipParkingStrategy;

	@Test
    public void testPark_givenAVipCarAndAFullParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 4, Write a test case on VipParkingStrategy.park()
	    * With using Mockito spy, verify and doReturn */
        //given
        VipParkingStrategy vipParkingStrategy = spy(new VipParkingStrategy());
        Car mockedCar = mock(Car.class);
        ParkingLot mockedParkingLot = mock(ParkingLot.class);
        doReturn("car").when(mockedCar).getName();
        doReturn("parkingLot").when(mockedParkingLot).getName();
        doReturn(true).when(vipParkingStrategy).isAllowOverPark(mockedCar);

        //when
        vipParkingStrategy.park(Arrays.asList(mockedParkingLot), mockedCar);

        //then
        verify(vipParkingStrategy).createReceipt(mockedParkingLot, mockedCar);

    }

    @Test
    public void testPark_givenCarIsNotVipAndAFullParkingLog_thenGiveNoSpaceReceipt() {

        /* Exercise 4, Write a test case on VipParkingStrategy.park()
         * With using Mockito spy, verify and doReturn */
        //given
        VipParkingStrategy vipParkingStrategy = spy(new VipParkingStrategy());
        Car mockedCar = mock(Car.class);
        ParkingLot mockedParkingLot = mock(ParkingLot.class);
        doReturn("car").when(mockedCar).getName();
        doReturn("parkingLot").when(mockedParkingLot).getName();
        doReturn(false).when(vipParkingStrategy).isAllowOverPark(mockedCar);
        doReturn(true).when(mockedParkingLot).isFull();
        //when
        vipParkingStrategy.park(Arrays.asList(mockedParkingLot), mockedCar);

        //then
        verify(vipParkingStrategy).createNoSpaceReceipt(mockedCar);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsVipCar_thenReturnTrue(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
        //given
        when(car.getName()).thenReturn("vipA");
        when(carDao.isVip(any())).thenReturn(true);

        //when
        Boolean actual = this.vipParkingStrategy.isAllowOverPark(car);

        //then
        assertEquals(true, actual);

    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsVipCar_thenReturnFalse(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsNotVipCar_thenReturnFalse(){
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
    }

    private Car createMockCar(String carName) {
        Car car = mock(Car.class);
        when(car.getName()).thenReturn(carName);
        return car;
    }
}
