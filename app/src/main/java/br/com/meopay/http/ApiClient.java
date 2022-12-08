package br.com.meopay.http;

public class ApiClient {

    private static ApiClient single_instance = null;

    private ApiClient() { }

    public static ApiClient getInstance()
    {
        if (single_instance == null)
            single_instance = new ApiClient();

        return single_instance;
    }
}
