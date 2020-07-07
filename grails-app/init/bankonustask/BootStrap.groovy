package bankonustask

import org.bankonus.Customer
import org.bankonus.Mobile

class BootStrap {

    def init = { servletContext ->

      def c=  new Customer(name: "ahmed").addToMobile(new Mobile(number:"345455454",activated: false))
              .addToMobile(new Mobile(number:"345455454",activated: false))
              .addToMobile( new Mobile(number:"0502026306",activated: false))
              .save()

          new Customer(name: "ahmed2").addToMobile(new Mobile(number:"3454525454",activated: true))
                .addToMobile(new Mobile(number:"34545545254",activated: false))
                .addToMobile( new Mobile(number:"05020256306",activated: true))
                .save()

        def mobileList = Mobile.executeQuery('select mo from Mobile mo '+ "where mo.customer.id = :id",
                [id: 1l])
        println(mobileList)


    }
    def destroy = {
    }
}