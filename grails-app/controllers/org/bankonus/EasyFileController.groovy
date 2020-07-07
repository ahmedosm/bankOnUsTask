package org.bankonus

import static org.springframework.http.HttpStatus.CREATED

class EasyFileController {
    UserAccountService userAccountService
    UserAccountValidationService userAccountValidationService

    def index() {}

    def upload() {
        log.info 'i am here i am not danger i am the danger'
        try {
            def f = request.getFile('myFile')
            if (f.empty) {
                flash.message = 'file cannot be empty'
            }

            f.inputStream.eachLine { line ->
                if (line) {
                    def indexed = line.toString().replace(' ', '').split(',')

                    if (userAccountValidationService.customValidation(indexed)) {
                        userAccountService.save(new UserAccount(name: indexed[2], accountId: indexed[0], amount: indexed[1]))
                    } else {
                        println("line with id : " + indexed[0] + " skiped")
                        log.info "line with id : " + indexed[0] + " skiped"
                    }

                }


            }
        } catch (Exception e) {
            e.printStackTrace()
            log.error "Error occurred on save!"
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'easyFile.label', default: 'EasyFile'), userAccountService.count()])
                redirect(uri: '/easyFile')
            }
            '*' { respond userAccountService.count(), [status: CREATED] }
        }
    }

}
