package prog2.exercise5.flight.booking.system;


/**
 * Hello world!
 *
 */
import java.time.LocalDate;

//字符串转换为日期(报错)   random(解决)   字符串串联创建number ?  get set number(解决)
//2 Add an attribute for BookingClass可能在flight booking操作，get set  通过123来底层操作First  Business Economy(完成）
// 3. Update the attribute of tripType更新tripType的现有属性，使其可以保存单向的两个选项和返回。因此，乘客必须有选择权。这个选择必须完全如下所示。这些选项必须作为字符串接受：
//1.单向（设置内部逻辑）（完成）
//2.返回     为字符串格式，程序自动适配出发机场(似乎完成）
// 1. Nanjing        8. Conditional total ticket price  国内基本票价=300欧元税费=基础票价的10%服务费=基础票价的5%
//2. Beijing          国际   300  15  10      fir+250   bus  150   Economic 50  总票价=基本票价+税费+服务费+预订等级 儿童成年
//3.Oulu        departing ticket price 两个参数      set  total return  不设参数
//4. Helsinki  6Conditional trip dates   必须2天以上，若少了系统自动适配7. Conditional ticket number generation票号长10个字符
//单程票11开头回程22   first则后面加F 以此类推  国内旅行则DOM结尾国际INT
//9. Confirmation message 最后
//exercise-5   passengerFullName(两个参数）  passengerGender  passengerAge  ticketNumber(数组) 仅接受设置者唯一票号所在的index
//任务3。创建一个将初始化所有数组的构造函数//修改构造函数，使其仅接受用户所需的票证总数保留，然后使用该数字初始化程序中的所有数组。
//4 reserveTickets  创建一个名为reserveTickets的新方法，该方法接受用户的总计输入他们要预订的机票数量。创建必要的逻辑，允许用户运行不同的阵列及其输入不同值的单个索引。例如，如果用户想要预订的门票总数为3，
// 则该逻辑应当允许用户输入详细信息（例如passengerFullName，passenger性别、passengerAge此方法还应要求用户输入将存储的其他详细信息，如之前（例如，tripSource、tripDestination、tripType、bookingClass等）该方法还应考虑不同变量的设置值（例如。，departureDate、returnDate、ticketPrice等）此方法还将处理为与用户已请求。
//5  displayTripDetails 数组正则变量以显示信息
public class Main {
    public static void main(String[] args) {
        //   Calendar calendar = Calendar.getInstance();
        //   System.out.println(calendar.getTime().toString());  // Mon Aug 15 18:19:55 CST 2022

        //  calendar.add(Calendar.YEAR, 2);                     // Mon Aug 15 18:19:55 CST 2024
        //  calendar.add(Calendar.MONTH, -6);                   // Thu Feb 15 18:19:55 CST 2024
        // calendar.add(Calendar.DAY_OF_MONTH, 14);            // Thu Feb 29 18:19:55 CST 2024

        //System.out.println(calendar.getTime().toString());  // Thu Feb 29 18:19:55 CST 2024
        String BookingClass;

        String sdepart = "2023-03-04";
        LocalDate depart = LocalDate.parse(sdepart);
        String sreturn = "2023-03-05";
        LocalDate returnDate = LocalDate.parse(sreturn);
        String FlightID = "FOF" + Math.random() * 9000 + 1000 + "IN";// flightID


        String sourceAirport = "NANJING LUKOU INTERNATIONAL AIRPORT";
        String destinationAirport = "OULU AIRPORT";
        int size = 3;
        FlightBooking fb = new FlightBooking(size);
        int expResult = 4;
        fb.setTotalPassengers(1, 3);
        int result = fb.getTotalPassengers();

        fb.setPassengerFullName(1, "John Doe");
        //   fb.setTicketNumber();
        //   fb = new FlightBooking(null, null, null, 0, 0);
        fb.setTripSource("2");
        fb.setTripDestination("OULU", " Helsinki");
        fb.setFlightCompany("Flights-of-Fancy");
        fb.setDepartureDate(depart);
        fb.setReturnDate(returnDate);
        //fb.setBookingClass("");

        //    int child = 2;
        // int adults = 5;
        // double returnedPrice = Math.abs(fb.getTotalTicketPrice());
        // double expectedPrice = Math.abs((((child *((300 + (0.1*300)) + (0.05*300))) + (adults*((300 + (0.1*300)) + (0.05*300)))) + 250)*2);
        size = 3;

        String[] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String[] gender = {"Male", "Female", "Other"};
        int[] age = {43, 32, 21};
        for (int i = 0; i < size; ++i) {
            fb.setPassengerFullName(i, fullName[i]);
            fb.setPassengerGender(i, gender[i]);
            fb.setPassengerAge(i, age[i]);

        }

        for (int j = 0; j < size; ++j) {
            if ((fb.getPassengerFullName(j) == fullName[j]) && (fb.getPassengerGender(j) == gender[j])
                    && fb.getPassengerAge(j) == age[j]) {
                fb.setPassengerFullName(1, "Matt Jive");
            } else {
                fb.setPassengerFullName(1, "Sally Fields");
            }
        }
        for (int j = 0; j < size; ++j) {
            fb.setTicketNumber(j);
        }

        System.out.println("Dear " + fb.getPassengerFullName(1) + ". Thank you for booking your flight with " +
                fb.getFlightCompany() + ".\n Following are the details of your booking and the trip:" + "\n" +
                "Ticket Number: " + fb.getTicketNumber(1) + "\n" +
                "From " + fb.getTripSource() + " to " + fb.getTripDestination() + "\n" +
                "Date of departure: " + fb.getDepartureDate() + "\n" +
                "Date of return: " + fb.getReturnDate() + "\n" +
                "Total passengers: " + fb.getTotalPassengers() + "\n" +
                "Total ticket price in Euros: " + fb.getTotalTicketPrice());
    }
}
//Thank you for booking your flights with FLIGHT_COMPANY.
//You reserved a total of 1/2/3/… tickets.
//Here are the trip details for Passenger No.1/2/3/…
//Passenger's Ticket Number: ticketNumber
//Passenger's Full Name: passengerFullName
//Passenger's Age: passengerAge
//Passenger's Gender: passengerGender
//From: tripSource (sourceAirport)
//To: tripDestination (destinationAirport)
//The flight departs on: departureDate)
//And the return flight is on: returnDate (Changed from old returningDate to new
//returningDate)
//(After displaying all the individual ticket details, display the total ticket price.)
//The total ticket price is: totalTicketPrice--


//IMPORTANT NOTICE: As per our policy, the return date was changed because it was less
//than two days apart from your departure date.
//If the return date was not changed, then the message should be as follows:


//Thank you for booking your flights with FLIGHT_COMPANY.
//You reserved a total of 1/2/3/… tickets.
//Here are the trip details for Passenger No.1/2/3/…
//Passenger's Ticket Number: ticketNumber
//Passenger's Full Name: passengerFullName
//Passenger's Age: passengerAge
//Passenger's Gender: passengerGender
//From: tripSource (sourceAirport)
//To: tripDestination (destinationAirport)
//The flight departs on: departureDate)
//And the return flight is on: returnDate
//(After displaying all the individual ticket details, display the total ticket price.)
//The total ticket price is: totalTicketPrice