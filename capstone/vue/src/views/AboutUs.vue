<template>
    <div>
        <div>
            <h1>About Us</h1>
            <p class="message">Meet the team that brings the kudos to the kiddos.</p>
        </div>
        <div class="profile">
        <div>
          <a href="https://www.linkedin.com/in/jimcastillejo//">
          <img src="https://media-exp1.licdn.com/dms/image/C4E03AQGdG68vCB8fxQ/profile-displayphoto-shrink_200_200/0/1589820732413?e=1670457600&v=beta&t=qLK1PBXGThMbWD5DONIAi4n3zk65QaJnBjRNZxYFJz8" alt="">
          </a>
          <h2>Jimmy Castillejo</h2>
        </div>
        <div>
          <a href="https://www.linkedin.com/in/laura-diaco/">
          <img src="https://media-exp1.licdn.com/dms/image/C5603AQHIXaDW0NgcKA/profile-displayphoto-shrink_200_200/0/1656860445505?e=1670457600&v=beta&t=tQ0vI_ae_bmPLCIAxjXiupVI6cpKUUsdA6Ha4jHmf00" alt="">
          </a>
          <h2>Laura Diaco</h2>
        </div>
        <div>
          <a href="https://www.linkedin.com/in/katiekasberg//">
          <img src="https://media-exp1.licdn.com/dms/image/C5603AQFARytw3TswSQ/profile-displayphoto-shrink_200_200/0/1660599406261?e=1670457600&v=beta&t=h12pBlGqJKDKBuAkwaIENQdwhRFWrFWHwm21ySptV08" alt="">
          </a>
          <h2>Katie Kasberg</h2>
        </div>
        <div>
          <a href="https://www.linkedin.com/in/anthony-ahrens/">
          <img src="https://media-exp1.licdn.com/dms/image/C4E03AQFEZzIe_AK25w/profile-displayphoto-shrink_200_200/0/1614627841237?e=1670457600&v=beta&t=Bqez4qUk8t9oVjlrJg6rLz46fcDsPSMvCFCKEgEjNl8" alt="">
          </a>
          <h2>Anthony Ahrens</h2>
        </div>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style scoped>
.profile {
    display: flex;
    gap: 20px;
    justify-items:space-between;
    text-align: center;
    font-family:Arial, Helvetica, sans-serif;
}
.message{
    text-align: center;
    font-family:Arial, Helvetica, sans-serif;
}

img{
    border-radius: 50%;
    padding-top: 50px
}

</style>