package com.example.thagadur.android_sessio19_assignment1.network;

import com.example.thagadur.android_sessio19_assignment1.utils.CommonUtilities;

/**
 * Created by Thagadur on 11/2/2017.
 */

public interface OnWebServiceResult {
    public void getWebResponse(String result, CommonUtilities.SERVICE_TYPE type);
}
