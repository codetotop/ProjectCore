package com.dungnb.gem.projectcore.webservice.content;

import android.annotation.SuppressLint;

import com.dungnb.gem.projectcore.pojo.business_model.QuestionDTO;
import com.dungnb.gem.projectcore.pojo.business_model.SourceInformationPersonnelDTO;
import com.dungnb.gem.projectcore.pojo.model.Question;
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
            .flatMap(questionResponse -> {
              ArrayList<QuestionDTO> questionDTOS = (ArrayList<QuestionDTO>) questionResponse.getQuestionDTOS();
              ArrayList<Question> questions = new ArrayList<>();
              for (int i = 0; i < questionDTOS.size(); i++) {
                Question question = new Question();
                question.convert(questionDTOS.get(i));
                questions.add(question);
              }
              return Single.just(questions);
            });
  }
}
