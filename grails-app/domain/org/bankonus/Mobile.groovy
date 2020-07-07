package org.bankonus






class Mobile{
    String number
    boolean activated
    static belongsTo = [customer:Customer]

    static constraints = {
        number blank:false

    }
}
