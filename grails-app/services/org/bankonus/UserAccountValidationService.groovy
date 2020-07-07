package org.bankonus


import grails.gorm.services.Service

@Service
class UserAccountValidationService {

    def customValidation(def indexed) {
        if (indexed && indexed.length == 3 &&
                validateUserAccountId(indexed[0]) && validateUserAccountAmount(indexed[1])){
            return true
        }


    }

    def validateUserAccountId(String id) {
        if (id.isNumber() && id.length() == 10)
            return true
    }

    def validateUserAccountAmount(String amount) {
        if (amount.isNumber() && Double.parseDouble(amount) > 0)
            return true


    }


}
