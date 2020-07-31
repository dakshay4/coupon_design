package com.dakshay.BookingController;

import com.dakshay.request.FlightSearchRequest;
import com.dakshay.response.CommonResponseBean;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dakshay on 12/24/2018.
 */
@RestController
@RequestMapping("/booking")
public class BookingEngineController {

    @PostMapping("/searchFlights")
    public @ResponseBody CommonResponseBean searchFlights(@RequestBody FlightSearchRequest flightSearchRequest){
        CommonResponseBean commonResponseBean = new CommonResponseBean();

        return commonResponseBean;
    }
}
