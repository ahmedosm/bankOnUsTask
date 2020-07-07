package bankonustask

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/mobiles"(resources:"mobile"){
            collection {
                '/customerMobile'(controller: 'mobile', action: 'customerMobile')
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
