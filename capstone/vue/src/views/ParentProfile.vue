<template>
  <div>
    <div class="parent-profile">
        <div>
          <parent-detail v-bind:parentId="parseInt($route.params.id)" />
          <list-children v-bind:parentId="parseInt($route.params.id)" />
          <claim-student v-bind:parentId="parseInt($route.params.id)" />
        </div>
    </div>
  </div>
</template>

<script>
import ClaimStudent from '../components/ClaimStudent.vue'
import ListChildren from '../components/ListChildren.vue'
import ParentDetail from '../components/ParentDetail.vue'
export default {
  components: { ParentDetail, ListChildren, ClaimStudent },
  name: 'ParentProfile',


}
</script>

<style>

</style>