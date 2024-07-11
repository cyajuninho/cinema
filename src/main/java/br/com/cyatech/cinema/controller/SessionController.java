package br.com.cyatech.cinema.controller;

import br.com.cyatech.cinema.model.Session;
import br.com.cyatech.cinema.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    /**
     * Salva uma sessão
     * @param session    Sessão a ser salva
     * @return Session com status 200
     */
    @PostMapping("/save")
    public ResponseEntity<Session> saveSession(Session session) {
        return ResponseEntity.ok(sessionService.saveSession(session));
    }

    /**
     * Busca uma sessão pelo id
     * @param id    Id da sessão
     * @return Session com status 200
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Session> findSessionById(Long id) {
        return ResponseEntity.ok(sessionService.findSessionById(id));
    }

    /**
     * Atualiza uma sessão
     * @param id        Id da sessão
     * @param session   Sessão a ser atualizada
     * @return Session com status 200
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Session> updateSession(Long id, Session session) {
        return ResponseEntity.ok(sessionService.updateSession(id, session));
    }

    /**
     * Deleta uma sessão pelo id
     * @param id    Id da sessão
     * @return ResponseEntity com status 200
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSession(Long id) {
        sessionService.deleteSessionById(id);
        return ResponseEntity.ok().build();
    }

}
