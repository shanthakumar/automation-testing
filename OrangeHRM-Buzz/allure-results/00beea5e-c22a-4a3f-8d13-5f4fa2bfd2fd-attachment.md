# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: BuzzTest.spec.js >> Test Buzz
- Location: tests/BuzzTest.spec.js:5:5

# Error details

```
Error: locator.tap: The page does not support tap. Use hasTouch context option to enable touch support.
```

# Test source

```ts
  1  | import { test, expect } from 'playwright/test'
  2  | 
  3  | export class DashboardPage {
  4  |     constructor(page)
  5  |     {
  6  |         this.page = page
  7  |         this.buzzLink = page.getByRole('link').filter({hasText: 'Buzz'})
  8  |     }
  9  | 
  10 |     async selectBuzz() {
> 11 |         await this.buzzLink.tap()
     |                             ^ Error: locator.tap: The page does not support tap. Use hasTouch context option to enable touch support.
  12 |     }
  13 | }
```