package org.bankonus

import groovy.transform.ToString


@ToString
class UserAccount {

    String name
    Long accountId
    Double amount
    static constraints = {
        accountId size: 10
        amount min: 0.0d
    }



}