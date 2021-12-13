package com.gpw.cma.service

import com.gpw.cma.domain.entity.Client
import com.gpw.cma.domain.repository.CMARepository
import com.gpw.cma.service.impl.ClientServiceImpl
import spock.lang.Specification

import java.time.LocalDate

class ClientServiceReadSpec extends Specification {
    ClientService clientService
    CMARepository cmaRepository = Mock()

    def setup() {
        clientService = new ClientServiceImpl(
                cmaRepository
        )
    }

    def "add() method test"() {
        given:
        Client clientToAdd = new Client()

        clientToAdd.date = LocalDate.now()
        clientToAdd.email = 'test@test.com'
        clientToAdd.firstName = 'Name'
        clientToAdd.lastName = 'Surname'

        Client savedClient = null

        when:
        savedClient = clientService.create(clientToAdd)

        then:
        1 * cmaRepository.save(_ as Client) >> {
            Client client ->
                savedClient = client
        }
        savedClient.lastName == clientToAdd.lastName
        savedClient.firstName == clientToAdd.firstName
        savedClient.email == clientToAdd.email
        savedClient.date == clientToAdd.date
    }
}
