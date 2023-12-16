# org.openapitools.client - Kotlin client library for Auth service

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://127.0.0.1:9000/api/v1*

| Class     | Method                                           | HTTP request            | Description                                  |
|-----------|--------------------------------------------------|-------------------------|----------------------------------------------|
| *UserApi* | [**registerUser**](docs/UserApi.md#registeruser) | **POST** /user/register | Регистрация пользователя                     |
| *UserApi* | [**userInfo**](docs/UserApi.md#userinfo)         | **GET** /user_info      | Получение информации о пользователе для OIDC |

<a name="documentation-for-models"></a>
## Documentation for Models

- [org.openapitools.client.models.Error](docs/Error.md)
- [org.openapitools.client.models.User](docs/User.md)
- [org.openapitools.client.models.UserInfo](docs/UserInfo.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
