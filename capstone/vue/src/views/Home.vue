<template>
  <div class="home">
    <div class="container">
      <div class="Aside-nav">
        <aside>
          <nav>
            <ul>
              <li><a href="#">Home</a></li>
              <li><a href="#">Send Kudos</a></li>
              <li><a href="#">Behavioral Report</a></li>
              <li><a href="#">Search Students</a></li>
              <li><a href="#">Make Announcements</a></li>
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
      <div class="search">
        <h2>Search Students</h2>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 0.6fr 1.2fr 1.2fr;
  grid-template-rows: 0.7fr 0.7fr 0.7fr 1fr;
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

aside{
  position:fixed;
  border-collapse: separate;
  border-color: rgba(243, 1, 1, 0.815);
  border-right: 1px solid rgba(174, 238, 0, 0.4);
  height: 100%;
  width: 200px;

}

ul{
  text-align: center;
  margin: 0;
  padding: 0;
}

ul>li{
  display: block;
  text-align: center;
  text-transform: uppercase;
  border-color: rgba(0, 173, 238, 0.4);
  padding: 15px;
  border-bottom: 1px solid rgba(0, 173, 238, 0.4);
  list-style: none;
  width: 95%;

}
</style>