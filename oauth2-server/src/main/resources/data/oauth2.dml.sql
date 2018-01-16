TRUNCATE OAUTH_CLIENT_DETAILS;

INSERT INTO OAUTH_CLIENT_DETAILS
(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, WEB_SERVER_REDIRECT_URI,AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY, ADDITIONAL_INFORMATION, CREATE_TIME, ARCHIVED, TRUSTED)
VALUES
('70d7c0424190ec81726664d1dd93cfe5', 'b0adf4baa36c00c4', '91ee593b1c46b22874e11ac12278d2f4528d7594', 'read', 'authorization_code,password,client_credentials,implicit,refresh_token', null, 'ROLE_CLIENT', null, null, null, now(), 0, 0),
('d5859c8a099e4ebc26a2bcdd400c9db0', 'd2c8634bad8f25cc', 'a12f77d38319e10f4d1a7bea6df8f36928febda2', 'read', 'authorization_code,password,client_credentials,implicit,refresh_token', null, 'ROLE_CLIENT', null, null, null, now(), 0, 0);
