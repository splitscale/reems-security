package com.splitscale.reems.history;

import com.splitscale.reems.core.history.delete.DeleteHistoryInteractor;
import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.security.wrappers.history.delete.DeleteHistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.*;

public class DeleteHistoryTest {

  @Mock
  private DeleteHistoryInteractor interactor;

  @Mock
  private SecurityService securityService;

  private DeleteHistory wrapper;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    wrapper = new DeleteHistory(securityService, interactor);
  }

  @Test
  public void testDeleteHistory() throws IOException, GeneralSecurityException {
    // Arrange
    String id = "123";

    // Act
    wrapper.delete(id, "jwtToken", "userId");

    // Assert
    verify(securityService, times(1)).validateJwt("jwtToken", "userId");
    verify(interactor, times(1)).deleteHistoryById(id);
  }

  @Test
  public void testDeleteAllHistory() throws IOException, GeneralSecurityException {
    // Act
    wrapper.deleteAll("jwtToken", "userId");

    // Assert
    verify(securityService, times(1)).validateJwt("jwtToken", "userId");
    verify(interactor, times(1)).deleteAllHistory();
  }
}
