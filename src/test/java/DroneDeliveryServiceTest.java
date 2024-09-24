import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DroneDeliveryServiceTest {
    private final DroneDeliveryService sut = new DroneDeliveryService();
    
    @Test
    @DisplayName("Should return 'S' if the box can fit in the window given box values smaller than the window")
    public void deliverSuccess() {
        
        char result = sut.deliver(1,2,3,4,5);
        
        assertThat(result).isEqualTo('S');
    }
    
}
