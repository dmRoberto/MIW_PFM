package es.upm.miw.pwitter.rest.server.controller;

import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.pwitter.model.beans.Competition;
import es.upm.miw.pwitter.model.beans.Message;
import es.upm.miw.pwitter.model.handler.IHandlerCompetitions;

@RestController
public class CompetitionController {

	private final static Log LOG = LogFactory
			.getLog(CompetitionController.class);

	@Inject
	private IHandlerCompetitions handlerCompetitions;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Message doPost(@RequestBody Competition competition) {
		LOG.info("Se inserta una competicion");
		handlerCompetitions.addCompetition(competition);
		Message result = new Message("Insertado correctamente", Boolean.TRUE);
		return result;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Set<Competition> getAllCompetitions() {
		LOG.info("Se recuperan todas las competiciones");
		return handlerCompetitions.getCompetitions();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Competition getCompetitionByNameCountryAndSport(
			@PathVariable("id") Integer id) {
		LOG.info("Se recupera una competicion");
		Competition competition = new Competition(id);
		return handlerCompetitions.findCompetition(competition);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody Message updateCompetition(
			@RequestBody Competition competition) {
		LOG.info("Se actualiza una competicion");
		handlerCompetitions.updateCompetition(competition);
		Message result = new Message("Borrado correctamente", Boolean.TRUE);
		return result;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody Message deleteCompetition(
			@RequestBody Competition competition) {
		LOG.info("Se borra una competicion");
		handlerCompetitions.removeCompetition(competition);
		Message result = new Message("Borrado correctamente", Boolean.TRUE);
		return result;
	}

}