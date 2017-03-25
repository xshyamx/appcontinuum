package io.barinek.continuum.accounts

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(val gateway: AccountDataGateway) {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/accounts")
    fun list(@RequestParam ownerId: String): List<AccountInfo> {
        return gateway.findBy(ownerId.toLong()).map { record ->
            AccountInfo(record.id, record.ownerId, record.name, "account info")
        }
    }
}