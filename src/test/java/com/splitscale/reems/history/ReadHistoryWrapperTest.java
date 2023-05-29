package com.splitscale.reems.history;

import com.splitscale.reems.history.read.ReadHistoryInteractor;
import com.splitscale.reems.security.wrappers.history.read.ReadHistoryWrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReadHistoryWrapperTest {

    @Mock
    private ReadHistoryInteractor interactor;

    private ReadHistoryWrapper wrapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        wrapper = new ReadHistoryWrapper(interactor);
    }

    @Test
    public void testGetAllHistory() throws IOException, GeneralSecurityException {
        // Arrange
        List<History> expectedHistoryList = new ArrayList<>();
        expectedHistoryList.add(new History("1", "Event 1", null, null));
        expectedHistoryList.add(new History("2", "Event 2", null, null));

        when(interactor.getAllHistory()).thenReturn(expectedHistoryList);

        // Act
        List<History> actualHistoryList = wrapper.getAllHistory();

        // Assert
        assertEquals(expectedHistoryList, actualHistoryList);
        verify(interactor, times(1)).getAllHistory();
    }

    @Test
    public void testGetHistoryById() throws IOException, GeneralSecurityException {
        // Arrange
        String id = "1";
        History expectedHistory = new History(id, "Event 1", id, null);

        when(interactor.getById(id)).thenReturn(expectedHistory);

        // Act
        History actualHistory = wrapper.getHistoryById(id);

        // Assert
        assertEquals(expectedHistory, actualHistory);
        verify(interactor, times(1)).getById(id);
    }
}
