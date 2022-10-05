<template>
  <body>
    <div class="home-nav">
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
    </div>
    <p>
      Welcome to the School Communication app! This is your hub for
      communication of student behaviors between school and home. We pride
      ourselves on simplifying the process of digital communication about
      student progress and behavior between schools and families.<br />
      <br />Please log in to start connecting!
    </p>
  </body>
</template>

<script>
</script>

<style scoped>
p {
  display: grid;
  align-items: center;
  justify-items: center;
  font-family: Arial, Helvetica, sans-serif;
  color: rgb(216, 150, 69);
  max-width: 50%;
  /* margin-left: 375px; */
  padding-bottom: 600px;
}
.home-nav {
  display: grid;
  justify-content: center;
  flex-direction: column;
}
ul {
  list-style: none;
}
button {
  padding: 10px;
  margin: 10px;
  margin-left: 20px;
  background-color: white;
  border-radius: 10%;
  border-color: orange;
}
/* aside {
  display: grid;
  position: fixed;
  border-collapse: separate;
  justify-items: center;

  height: 100%;
  width: 200px;
  background-color: #ffc83c57;
} */
a {
  color: black;
  text-decoration: none;
  font-weight: bold;
}
</style>