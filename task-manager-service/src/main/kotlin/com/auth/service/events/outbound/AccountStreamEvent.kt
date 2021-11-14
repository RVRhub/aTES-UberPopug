package com.auth.service.events.outbound

data class AccountStreamEvent(
    var publicId: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var eventName: String? = null
)
