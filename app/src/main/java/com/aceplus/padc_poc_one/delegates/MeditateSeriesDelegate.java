package com.aceplus.padc_poc_one.delegates;

import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;

/**
 * Created by kkk on 5/26/2018.
 */

public interface MeditateSeriesDelegate {
    void onTapItem(CurrentProgramVO currentProgramVO);

    void onTapListItem(CategoriesProgramsItemVO categoriesProgramsItemVO);
}
