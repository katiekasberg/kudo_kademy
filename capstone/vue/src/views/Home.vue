<template>
  <body>
    <div class="home">
      <div class="container">
        <div class="Aside-nav">
          <aside>
            <nav>
              <ul>
                <li>
                  <button><a href="#">Home</a></button>
                </li>
                <li>
                  <button>
                    <router-link to="/SendKudos">Send Kudos</router-link>
                  </button>
                </li>
                <li>
                  <button><a href="#">Behavioral Report</a></button>
                </li>
                <li>
                  <button><a href="#">Search Students</a></button>
                </li>
                <li>
                  <button><a href="#">Make Announcements</a></button>
                </li>
                <li>
                  <button><a href="#">Add/Remove Student</a></button>
                </li>
                <li>
                  <button><a href="#">Add/Remove Teacher</a></button>
                </li>
                <li>
                  <button><a href="#">Set Kudo Values</a></button>
                </li>
                <li>
                  <button>
                    <router-link to="/logout"> Logout </router-link>
                  </button>
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
            <p>You must be authenticated to see this</p>
          </div>
        </div>
        <div class="Welcome-User">
          <h1>Welcome</h1>
        </div>
        <div class="Announcements">
          <h2>Announcements</h2>
          <input
            type="text"
            id="makeAnnouncement"
            placeholder="Enter Announcement"
          />
          <button type="submit" class="submitBtn">Submit</button>
        </div>
        <div class="search">
          <h2>Search Students</h2>
          <input type="text" id="searchStudent" placeholder="Search Student" />
          <button type="submit" class="submitBtn">Search</button>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 0.7fr 1.2fr 1.2fr;
  grid-template-rows: 0.7fr 0.2fr 0.7fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "Aside-nav Header Header"
    "Aside-nav Welcome-User Welcome-User"
    "Aside-nav Announcements Announcements"
    "Aside-nav search search";
}

.Aside-nav {
  grid-area: Aside-nav;
  justify-self: stretch;
  align-self: stretch;
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
}

.logo {
  grid-area: logo;
}

.Welcome-User {
  grid-area: Welcome-User;
}

.Announcements {
  grid-area: Announcements;
}

#makeAnnouncement {
  margin: auto;
  display: block;
  width: 50%;
  height: 50%;
  text-align: center;
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
}
p {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: rgb(216, 150, 69);
}

aside {
  display: grid;
  position: fixed;
  border-collapse: separate;
  border-color: rgba(243, 1, 1, 0.815);
  border-right: 1px solid lightgray;
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
  /* border-bottom: 1px solid rgba(0, 173, 238, 0.4); */
  list-style: none;
  width: 95%;
}
body {
  background-color: rgb(253, 223, 158);
}
button {
  padding: 10px;
  margin-left: 20px;
  background-color: rgb(253, 223, 158);
  border-radius: 10%;
  border-color: orange;
}
</style>