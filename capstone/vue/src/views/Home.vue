<template>
  <body>
    <div class="container">
      <aside>
        <nav>
          <ul>
            <li>
              <button><a href="/">Home</a></button>
            </li>
            <li>
              <button>
                <router-link to="/login">Login</router-link>
              </button>
            </li>
            <li>
              <button><a href="#">About us</a></button>
            </li>
            <li>
              <button><a href="#">Contact us</a></button>
            </li>
          </ul>
        </nav>
      </aside>
    </div>
    <div class="Header">
      <div class="app-name">
        <h1>School Communication</h1>
      </div>
      <div class="logo">
        <img
          class="logo"
          src="../../resources/school-icon-9.png"
          alt="school-logo"
        />
      </div>
    </div>
    <p>
      Welcome to the School Communication app! This is your hub for
      communication of student behaviors between school and home. We pride
      ourselves on simplifying the process of digital communication about
      student progress and behavior between schools and families.
    </p>
    <p>Please log in to start connecting!</p>
  </body>
</template>

<script>
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 0.7fr 0.2fr 0.7fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "Aside-nav Header "
    "Aside-nav Welcome-User"
    "Aside-nav Announcements "
    "Aside-nav search";
}

.Header {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "app-name app-name app-name"
    "logo logo logo"
    "logo logo logo";
  grid-area: Header;
  justify-content: center;
}

.app-name {
  grid-area: app-name;
  justify-items: center;
  text-decoration: underline;
  color: darkorange;
}

.logo {
  grid-area: logo;
}

.Welcome-User {
  grid-area: Welcome-User;
}

.Announcements {
  grid-area: Announcements;
  color: black;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
}

#makeAnnouncement {
  margin: auto;
  display: block;
  width: 50%;
  height: 50%;
  text-align: center;
  padding-bottom: 100px;
}

#searchStudent {
  margin: auto;
  display: block;
}

.submitBtn {
  margin: auto;
  display: block;
}

.search {
  grid-area: search;
}

img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
}
h1,
h2 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  letter-spacing: 2px;
}

p {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: rgb(216, 150, 69);
  max-width: 50%;
  margin-left: 375px;
}

aside {
  display: grid;
  position: fixed;
  border-collapse: separate;
  border-color: rgba(243, 1, 1, 0.815);
  border-right: 1px solid rgb(211, 211, 211);
  height: 100%;
  width: 200px;
}

ul {
  text-align: center;
  margin: 0;
  padding: 0;
}

ul > li {
  display: block;
  text-align: center;
  text-transform: uppercase;
  font-family: Arial, Helvetica, sans-serif;
  border-color: rgba(0, 173, 238, 0.4);
  padding: 15px;

  list-style: none;
  width: 95%;
}
body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
button {
  padding: 10px;
  margin-left: 20px;
  background-color: rgb(253, 223, 158);
  border-radius: 10%;
  border-color: orange;
}
</style>