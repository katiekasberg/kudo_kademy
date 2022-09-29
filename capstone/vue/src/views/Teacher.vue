<template>
  <div class="home">
    <div class="container">
      <div class="Aside-nav">
        <aside>
          <nav>
            <ul>
              <li><a href="#">Home</a></li>
              <li><router-link to="/SendKudos">Send Kudos</router-link></li>
              <li><a href="#">Behavioral Report</a></li>
              <li><a href="#">Search Students</a></li>
              <li><a href="#">Make Announcements</a></li>
              <li><a href="#">Add/Remove Student</a></li>
              <li><a href="#">Classes</a></li>
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
        <input
          type="text"
          id="makeAnnouncement"
          placeholder="Enter Announcement"
        />
        <button type="submit" class="submitBtn">Submit</button>
      </div>
      <div class="search-student">
        <h2>Search Students</h2>
        <input type="text" id="searchStudent" placeholder="Search Student" />
        <button type="submit" class="submitBtn">Search</button>
      </div>
    </div>
  </div>
  <!-- <div>
    <body>
      <h1>SCHOOL COMMUNICATION</h1>
      <img class="logo" src="../../resources/school-icon-9.png" alt="" />
      <nav>
        <button router-link:on="../teacher">Home</button>
        <button href="/SendKudos">Send Kudos</button>
        <button>Behavioral Report</button>
        <button>Search Students</button>
        <button>Classes</button>
      </nav>
      <h2>House Cup Leader Board</h2>
      <table></table>
    </body>
  </div> -->
</template>

<script></script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 0.7fr 0.2fr 0.7fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "Aside-nav  Header"
    "Aside-nav Welcome-User"
    "Aside-nav Announcements"
    "Aside-nav search-student";
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

.Announcements {
  grid-area: Announcements;
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
  position:fixed;
  margin-left: 0.5%;
  margin-right: 0.5%;
  padding-top: 100%;
  padding: 20px;
  width: 20%;
  /* filter: invert(1); */
  float: right;
  overflow: auto;
  border-radius: 5px;
  border-width: 3px;
  /* border-radius: 20%; */
  border-color:darkorange;
  background-color:black;
  opacity: 0.5;

}
ul{
  display: grid;
  align-items: center;
  color: darkorange; 
  /* color is not showing up?? */
   justify-items: center;
  justify-content: center;
}
ul>li{
  font-size: 20px;
  font-weight: bold;
  border-bottom: 1px solid;
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

button {
  margin-bottom: 20px;
}
</style>
  