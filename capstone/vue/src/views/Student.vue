<template>
  <div class="home">
    <div class="container">
      <div class="Aside-nav">
        <aside>
          <nav>
            <ul>
              <li><a href="#">Home</a></li>
              <li><a href="#">Kudo Report</a></li>
              <li><a href="#">Leaderboard</a></li>
              <li><a href="#">See Kudo Values</a></li>
              <li><router-link to="/logout"> Logout </router-link></li>
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
          <p>You must be authenticated to see this</p>
        </div>
      </div>
      <div class="Welcome-User">
        <h1>Welcome</h1>
      </div>
      <div class="Announcements">
        <h2>Announcements</h2>
      </div>
      <div class="House-Cup">
        <h2>House Cup Leaderboard</h2>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scope>
.container {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 0.7fr 0.2fr 0.7fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "Aside-nav Header"
    "Aside-nav Welcome-User"
    "Aside-nav Announcements"
    "Aside-nav House-Cup";
}

/* .Header {
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
} */

.app-name {
  grid-area: app-name;
  justify-items: center;
}

.logo {
  grid-area: logo;
}

.Welcome-User {
  grid-area: Welcome-User;
}

.House-Cup {
  grid-area: House-Cup;
}

.Announcements {
  grid-area: Announcements;
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
  text-shadow: 
  1px 0px 0px black,
  -1px 0px 0px black, 
  0px 1px 0px black,
  0px -1px 0px black;
}
p {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: rgb(216, 150, 69);
}

aside {
  position: fixed;
  margin-left:0.5%;
  margin-right: 0.5%;
  padding-top: 100%;
  padding: 20px;
  width: 20%;
  float: right;
  overflow: auto;
  border-radius: 5px;
  border-width: 3px;
  border-color: darkorange;
  background-color:black;
  height: 100%;
  opacity: 0.5;
}

ul {
  display: grid;
  align-items: center;
  color:darkorange;
  justify-items: center;
  justify-content: center;
  margin: 0;
  padding: 0;
}

li {
  font-size: 20px;
  font-weight: bold;
  display: block;
  text-align: center;
  text-transform: uppercase;
  font-family: Arial, Helvetica, sans-serif;
  border-color: darkorange;
  padding: 15px;
  border-bottom: 1px solid;
  width: 95%;
}

.home {
  background: linear-gradient(
    360deg,
    white,
    #ffc93c 10%,
    #ff9a3c 30%,
    #ff6f3c,
    #155263 90%
  );
  display: 100%;
}
</style>