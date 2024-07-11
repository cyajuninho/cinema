package br.com.cyatech.cinema.service;

import br.com.cyatech.cinema.model.Session;
import br.com.cyatech.cinema.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    /**
     * Salva uma sessão
     * @param session     Sessão a ser salva
     * @return Session
     */
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    /**
     * Busca uma sessão pelo id
     * @param id        Id da sessão
     * @return Session
     */
    public Session findSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    /**
     * Deleta uma sessão pelo id
     * @param id        Id da sessão
     */
    public void deleteSessionById(Long id) {
        sessionRepository.deleteById(id);
    }

    /**
     * Atualiza uma sessão
     * @param id          Id da sessão
     * @param session     Sessão a ser atualizada
     * @return Session
     */
    public Session updateSession(Long id, Session session) {
        Optional<Session> sessionOptional = sessionRepository.findById(id);
        if (sessionOptional.isPresent()) {
            Session sessionToUpdate = sessionOptional.get();
            sessionToUpdate.setMovie(session.getMovie());
            sessionToUpdate.setPrice(session.getPrice());
            sessionToUpdate.setDate(session.getDate());
            return sessionRepository.save(sessionToUpdate);
        }
        throw new RuntimeException("Sessão não encontrada");
    }
}
