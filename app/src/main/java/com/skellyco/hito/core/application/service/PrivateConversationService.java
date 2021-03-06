package com.skellyco.hito.core.application.service;

import android.app.Activity;

import androidx.lifecycle.LiveData;

import com.skellyco.hito.core.application.IPrivateConversationService;
import com.skellyco.hito.core.domain.IPrivateConversationRepository;
import com.skellyco.hito.core.model.entity.PrivateConversation;
import com.skellyco.hito.core.model.dto.MessageDTO;
import com.skellyco.hito.core.model.dto.PrivateConversationDTO;
import com.skellyco.hito.core.shared.Resource;
import com.skellyco.hito.core.shared.error.FetchDataError;
import com.skellyco.hito.core.shared.error.InsertDataError;

public class PrivateConversationService implements IPrivateConversationService {

    private IPrivateConversationRepository privateConversationRepository;

    public PrivateConversationService(IPrivateConversationRepository privateConversationRepository)
    {
        this.privateConversationRepository = privateConversationRepository;
    }

    @Override
    public LiveData<Resource<Void, InsertDataError>> createPrivateConversation(Activity activity, PrivateConversationDTO privateConversationDTO, MessageDTO messageDTO)
    {
        return privateConversationRepository.createPrivateConversation(activity, privateConversationDTO, messageDTO);
    }

    @Override
    public LiveData<Resource<Void, InsertDataError>> insertMessage(Activity activity, String privateConversationId, MessageDTO messageDTO)
    {
        return privateConversationRepository.insertMessage(activity, privateConversationId, messageDTO);
    }

    @Override
    public LiveData<Resource<PrivateConversation, FetchDataError>> getPrivateConversation(Activity activity, String firstInterlocutorId, String secondInterlocutorId)
    {
        return privateConversationRepository.getPrivateConversation(activity, firstInterlocutorId, secondInterlocutorId);
    }
}
