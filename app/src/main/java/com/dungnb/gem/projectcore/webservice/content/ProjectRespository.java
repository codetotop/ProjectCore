package com.dungnb.gem.projectcore.webservice.content;

import android.annotation.SuppressLint;

import com.dungnb.gem.projectcore.pojo.business_model.AnswerDTO;
import com.dungnb.gem.projectcore.pojo.business_model.QuestionDTO;
import com.dungnb.gem.projectcore.pojo.business_model.SearchDTO;
import com.dungnb.gem.projectcore.pojo.business_model.SourceInformationPersonnelDTO;
import com.dungnb.gem.projectcore.pojo.model.Answer;
import com.dungnb.gem.projectcore.pojo.model.Question;
import com.dungnb.gem.projectcore.pojo.model.Search;
import com.dungnb.gem.projectcore.pojo.model.SourceInformationPersonnel;
import com.dungnb.gem.projectcore.pojo.response.QuestionResponse;
import com.dungnb.gem.projectcore.pojo.response.SourceChildrenResponse;
import com.dungnb.gem.projectcore.webservice.WebServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

@SuppressLint("CheckResult")

public class ProjectRespository {
  public static Single<SourceChildrenResponse> fetchSourceChildrenList(int pageNum, int pageSize, String companyId, String organizationId, String parentId, String dmzDma) {
    return WebServiceBuilder.getInstance().getProjectService().fetchSourceChildrenList(pageNum, pageSize, companyId, organizationId, parentId, dmzDma)
            .flatMap(sourceChildrenResponse -> {
              return Single.just(sourceChildrenResponse);
            });

  }

  public static Single<List<SourceInformationPersonnel>> fetchSourceInformationPersonnel(String assetId, String organizationId, String companyId) {
    return WebServiceBuilder.getInstance().getProjectService().fetchSourceInformationPersonnel(assetId, organizationId, companyId)
            .flatMap(sourceInformationPersonnelDTOS -> {
              List<SourceInformationPersonnel> result = new ArrayList<>();
              for (SourceInformationPersonnelDTO personnelDTO : sourceInformationPersonnelDTOS) {
                SourceInformationPersonnel personnel = new SourceInformationPersonnel();
                personnel.convert(personnelDTO);
                result.add(personnel);
              }
              return Single.just(result);
            });
  }

  public static Single<List<Question>> fetchQuestions(String oder, String sort, String tagged, String site) {
    return WebServiceBuilder.getInstance().getProjectService().fetchQuestionList(oder, sort, tagged, site)
            .flatMap(baseStackOverFlowResponse -> {
              ArrayList<QuestionDTO> questionDTOS = (ArrayList<QuestionDTO>) baseStackOverFlowResponse.getItems();
              ArrayList<Question> questions = new ArrayList<>();
              for (int i = 0; i < questionDTOS.size(); i++) {
                Question question = new Question();
                question.convert(questionDTOS.get(i));
                questions.add(question);
              }
              return Single.just(questions);
            });
  }

  public static Single<List<Answer>> fetchAnswers(String order, String sort, String site) {
    return WebServiceBuilder.getInstance().getProjectService().fetchAnswersList(order, sort, site)
            .flatMap(answerDTOBaseStackOverFlowResponse -> {
              ArrayList<Answer> answers = new ArrayList<>();
              ArrayList<AnswerDTO> answerDTOS = (ArrayList<AnswerDTO>) answerDTOBaseStackOverFlowResponse.getItems();
              for (AnswerDTO answerDTO : answerDTOS) {
                Answer answer = new Answer();
                if (answerDTO != null) {
                  answer.convert(answerDTO);
                  answers.add(answer);
                }
              }
              return Single.just(answers);
            });
  }

  public static Single<List<Search>> fetchSearches(String oder, String sort, String tagged, String site) {
    return WebServiceBuilder.getInstance().getProjectService().fetchSearchList(oder, sort, tagged, site)
            .flatMap(baseStackOverFlowResponse -> {
              ArrayList<SearchDTO> searchDTOS = (ArrayList<SearchDTO>) baseStackOverFlowResponse.getItems();
              ArrayList<Search> searches = new ArrayList<>();
              for (int i = 0; i < searchDTOS.size(); i++) {
                Search search = new Search();
                search.convert(searchDTOS.get(i));
                searches.add(search);
              }
              return Single.just(searches);
            });

  }
}
