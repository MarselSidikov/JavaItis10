<#import "spring.ftl" as spring />
<html>
<head>
    <title><@spring.message 'profile.title'/></title>
</head>
<body>
<a href="?lang=ru">Русский</a>
<br>
<a href="?lang=en">English</a>
<div>
    <h1><@spring.message 'profile.first_name'/></h1>
    <h2>${user.firstName}</h2>
    <h1><@spring.message 'profile.last_name'/></h1>
    <h2>${user.lastName}</h2>
</div>
</body>
</html>
