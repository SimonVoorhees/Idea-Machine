<script setup lang="ts">
import IdeaItem from './IdeaItem.vue'
const props = defineProps(["ideas"]);
</script>

<template>
  <ul class="IdeaList">
    <!-- <IdeaItem v-for="idea in props.ideas" :idea="idea" /> -->
    <li v-for="(idea, index) in props.ideas" v-if="(index)%2">
        <IdeaItem
            :idea="idea"
         />
         <IdeaItem
            :idea="props.ideas[index+1]"
         />
    </li>
  </ul>
</template>

<style>
    .IdeaList{
        background-color: var(--orange);
        color: var(--blue);
        list-style: none;
        padding: 16px 32px;
        font-size: 48px;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        flex-wrap: wrap;
        gap: 12px;
    }
</style>
