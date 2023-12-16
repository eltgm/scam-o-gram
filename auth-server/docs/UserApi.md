# UserApi

All URIs are relative to *http://127.0.0.1:9000/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**registerUser**](UserApi.md#registerUser) | **POST** /user/register | Регистрация пользователя
[**userInfo**](UserApi.md#userInfo) | **GET** /user_info | Получение информации о пользователе для OIDC


<a name="registerUser"></a>
# **registerUser**
> User registerUser(username, password, name, surname, birthDate, sex, middleName, photo)

Регистрация пользователя

Создаем пользователя в сервере авторизации для использования его аккаунта в других сервисах

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserApi()
val username : kotlin.String = username_example // kotlin.String | Логин пользователя
val password : kotlin.String = password_example // kotlin.String | Пароль пользователя
val name : kotlin.String = name_example // kotlin.String | Имя пользователя
val surname : kotlin.String = surname_example // kotlin.String | Фамилия пользователя
val birthDate : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Дата рождения пользователя
val sex : kotlin.String = sex_example // kotlin.String | - ``male``: мужской - ``female``: женский 
val middleName : kotlin.String = middleName_example // kotlin.String | Отчество пользователя
val photo : java.io.File = /path/to/file.txt // java.io.File | Фото профиля пользователя
try {
    val result : User = apiInstance.registerUser(username, password, name, surname, birthDate, sex, middleName, photo)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#registerUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#registerUser")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **kotlin.String**| Логин пользователя |
 **password** | **kotlin.String**| Пароль пользователя |
 **name** | **kotlin.String**| Имя пользователя |
 **surname** | **kotlin.String**| Фамилия пользователя |
 **birthDate** | **java.time.LocalDate**| Дата рождения пользователя |
 **sex** | **kotlin.String**| - &#x60;&#x60;male&#x60;&#x60;: мужской - &#x60;&#x60;female&#x60;&#x60;: женский  | [enum: male, female]
 **middleName** | **kotlin.String**| Отчество пользователя | [optional]
 **photo** | **java.io.File**| Фото профиля пользователя | [optional]

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="userInfo"></a>
# **userInfo**
> UserInfo userInfo()

Получение информации о пользователе для OIDC

Получаем информацию о пользователе из токена oauth

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = UserApi()
try {
    val result : UserInfo = apiInstance.userInfo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#userInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#userInfo")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserInfo**](UserInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

