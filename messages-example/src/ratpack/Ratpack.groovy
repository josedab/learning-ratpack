import groovy.sql.Sql
import static ratpack.spring.Spring.*

import javax.sql.DataSource

import static ratpack.groovy.Groovy.ratpack

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.joda.JodaModule
import ratpack.jackson.JacksonModule
import org.joda.time.LocalDate
import messages.models.*
import static ratpack.jackson.Jackson.json
import static ratpack.jackson.Jackson.jsonNode

ratpack {
  bindings {
    ObjectMapper om = new ObjectMapper()
    om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    om.registerModule(new JodaModule())
    bindInstance(ObjectMapper, om)
    add new JacksonModule()
  }
  handlers {
    register spring(messages.Application)

    

    assets "public", "index.html"
  }
}
