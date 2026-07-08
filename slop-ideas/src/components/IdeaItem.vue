<script setup lang="ts">
import {getRandomArbitrary, getRandomColor} from "../utilities.ts"
const props = defineProps({ idea: String })
const rotation = getRandomArbitrary(-90, 90) + 'deg'
const randomMargin = `${getRandomArbitrary(0, 20)}, ${getRandomArbitrary(0, 20)}, ${getRandomArbitrary(0, 20)}, ${getRandomArbitrary(0, 20)},`
const randomBorderTop = `${getRandomArbitrary(0, 20)}px groove var(--red)`
const randomBorderRight = `${getRandomArbitrary(0, 20)}px inset var(--red)`
const randomBorderBottom = `${getRandomArbitrary(0, 20)}px outset var(--red)`
const randomBorderLeft = `${getRandomArbitrary(0, 20)}px ridge var(--red)`
const randomColor = getRandomColor()
const styleObject = {
  rotate: rotation,
  margin: randomMargin,
  color: randomColor,
  textShadow: `0px 0px 7px var(--cyan)`
  // borderTop: randomBorderTop,
  // borderRight: randomBorderRight,
  // borderBottom: randomBorderBottom,
  // borderLeft: randomBorderLeft,
}
const onClick = () => {

}
</script>

<template>
  <li class="IdeaItem" :style="styleObject" >
    <h3 class="IdeaItem-Name" :title=props.idea>
      {{ props.idea }}
    </h3>
  </li>
</template>
<style>
.IdeaItem {
  margin: 0;
  max-width: 100%;
  text-align: center;
  padding: 8px 32px;
  overflow: visible;
}
.IdeaItem-Name {
  cursor: pointer;
}
</style>
