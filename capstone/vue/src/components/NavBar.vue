<template>
  <body>
    <div
      class="teacher-nav"
      v-show="$store.state.user.authorities[0].name === 'ROLE_TEACHER'"
      style="display: inline"
    >
      <aside>
        <nav>
          <ul>
            <li>
              <button><a href="/teacher">Home</a></button>
            </li>
            <li>
              <button>
                <router-link
                  :to="{
                    name: 'TeacherProfile',
                    params: { id: $store.state.user.id },
                  }"
                  >My Profile</router-link
                >
              </button>
            </li>
            <li>
              <button>
                <router-link to="/SendKudos">Send Kudos</router-link>
              </button>
            </li>
            <!-- <li>
              <button><a href="#">Behavioral Report</a></button>
            </li> -->
            <li>
              <button><a href="/searchbystudent">Search Students</a></button>
            </li>
            <li>
              <button>
                <a href="/createannouncement">Make Announcements</a>
              </button>
            </li>
            <li>
              <button>
                <router-link to="/newclass">Create Class</router-link>
              </button>
            </li>
            <li>
              <button>
                <router-link to="/manage-classes">Manage Classes</router-link>
              </button>
            </li>
            <li>
              <button><a href="#">Classes</a></button>
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

    <div
      class="admin-nav"
      v-show="$store.state.user.authorities[0].name === 'ROLE_ADMIN'"
      style="display: inline"
    >
      <aside>
        <nav>
          <ul>
            <li>
              <button><a href="/admin">Home</a></button>
            </li>
            <li>
              <button>
                <router-link
                  :to="{
                    name: 'AdminProfile',
                    params: { id: this.$store.state.user.id },
                  }"
                  >My Profile</router-link
                >
              </button>
            </li>
            <li>
              <button>
                <router-link to="/SendKudos">Send Kudos</router-link>
              </button>
            </li>
            <!-- <li>
              <button><a href="#">Behavioral Report</a></button>
            </li> -->
            <li>
              <button><a href="/searchbystudent">Search Students</a></button>
            </li>
            <li>
              <button>
                <a href="/createannouncement">Make Announcements</a>
              </button>
            </li>
            <li>
              <button>
                <router-link to="/newclass">Create Class</router-link>
              </button>
            </li>
            <li>
              <button>
                <router-link to="/manage-classes">Manage Classes</router-link>
              </button>
            </li>
            <!-- <li>
              <button><a href="#">Add/Remove Teacher</a></button>
            </li> -->
            <li>
              <button><a href="/newkudotype">Set Kudo Values</a></button>
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
    <div
      class="student-nav"
      v-show="$store.state.user.authorities[0].name === 'ROLE_STUDENT'"
    >
      <aside>
        <nav>
          <ul>
            <li>
              <button><a href="/student">Home</a></button>
            </li>
            <li>
              <button>
                <router-link
                  :to="{
                    name: 'StudentProfile',
                    params: { id: this.$store.state.user.id },
                  }"
                  >My Profile</router-link
                >
              </button>
            </li>
            <li>
              <button><a href="#">Kudo Report</a></button>
            </li>
            <li>
              <button><a href="#">Leaderboard</a></button>
            </li>
            <li>
              <button>
                <router-link to="/rewards"> Kudo Values</router-link>
              </button>
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
    <div
      class="parent-nav"
      v-show="$store.state.user.authorities[0].name === 'ROLE_PARENT'"
    >
      <aside>
        <nav>
          <ul>
            <li>
              <button><a href="/parent">Home</a></button>
            </li>
            <li>
              <button>
                <router-link
                  :to="{
                    name: 'ParentProfile',
                    params: { id: this.$store.state.user.id },
                  }"
                  >My Profile</router-link
                >
              </button>
            </li>
            <li>
              <button><a href="#">Student Report</a></button>
            </li>
            <li>
              <button>
                <router-link to="/rewards"> Kudo Values</router-link>
              </button>
            </li>
            <li>
              <button><a href="#">Contact Teacher</a></button>
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
  </body>
</template>
<script>
export default {
  created() {
    console.log(this.$store.state.user);
    console.log(this.$store.state.user.authorities[0].name);
  },
};
</script>

<style scoped>
ul {
  list-style: none;
  justfy-items: center;
}
button {
  padding: 10px;
  margin: 10px;
  margin-left: 20px;
  background-color: white;
  border-radius: 10%;
  border-color: orange;
}
aside {
  display: grid;
  position: fixed;
  border-collapse: separate;
  justify-items: center;

  height: 100%;
  width: 200px;
  background-color: #ffc83c57;
}
a {
  color: black;
  text-decoration: none;
  font-weight: bold;
}
</style>