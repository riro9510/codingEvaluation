# Midtronics Android Coding Evaluation – Ricardo Ramos Olivares

**Thank you for the opportunity to participate in this technical evaluation.**  
I must confess that, coming from a Flutter/React Native background, diving into native Android and Java felt like a refreshing and interesting challenge. As I mentioned, my previous experience with Java was limited to integrating push notifications in Flutter projects, so this was a great chance to go deeper.

The first six hours of Friday evening (more like 6 PM to midnight!) were dedicated to studying and translating familiar engineering concepts (architecture, Big O time complexity, SOLID principles, etc.) into the Android/Java world. After that, the plan crystallized in my mind: build a clean, maintainable app using MVVM where it made sense, leverage XML resources as much as possible (Context provides O(1) access — perfect for performance), and keep my profile picture loaded from a URL to avoid unnecessary APK bloat.

With the plan clear, it was time to get to work. Below is a more technical overview of what I built and the reasoning behind key decisions.

## Video Demo
[Midtronics Coding Evaluation Demo](https://youtube.com/shorts/qB6EEN9KHmU?feature=share)

## Features
- **Profile Screen**  
  Personal profile with real photo (loaded via Glide from a raw GitHub URL), name, title, contact info, and a fully scrollable summary of experience and education.

- **Country List Screen**  
  Complete list of countries loaded from the provided XML resource, displayed in a RecyclerView with smooth click navigation.

- **Country Detail Screen**  
  On selection → HTTP GET to `https://restcountries.com/v3.1/name/{countryName}`.  
  Shows all required fields: name, capital, population, area, region, sub-region.  
  **Bonus**: Country flag loaded with Glide for a better visual experience.

- **Navigation**  
  Simple and intuitive flow: Profile → "Explore Countries" button → List → Detail, with natural back-stack support.

## Technical Highlights & Reasoning
- **100% pure Java** (no Kotlin) as requested.
- **MVVM pattern** used selectively (Country list) to separate concerns and make the code more testable/maintainable.
- **Repository pattern** for networking — encapsulates HTTP logic and makes future extensions (caching, offline support) easier.
- **Immutable CountryDetail model** — safer, easier to test, and prevents accidental state mutation.
- **XML resources** for static data (profile strings and country list) → O(1) access via Context, no parsing overhead.
- **Glide** for image loading (profile photo + flags) — handles caching, placeholders, and errors gracefully.
- **Background threading** with ExecutorService — avoids blocking the UI thread (no ANR risk).
- **Basic unit testing** and **GitHub Actions CI/CD** pipeline: tests → auto-merge to `main` → tagged release `v1.0.0`.
- `main` branch protected with required status checks.

## Development Process
- All work done on the `dev` branch
- Task tracking via Trello board: [Sprint Android Coding Evaluation - Midtronics](https://trello.com/b/WHHudAET/sprint-android-coding-evaluation-midtronics)
- Transparent commit history showing incremental progress

## How to Run
1. Clone the repository
2. Open in Android Studio
3. Run on an emulator or physical device (minSdk 24)

The app launches directly into the profile screen.

## Final Thoughts
This evaluation was a fantastic learning experience. I focused not only on meeting the requirements but on applying solid engineering practices while adapting quickly to a new stack. I'm satisfied with the result and even more excited about the possibility of bringing this same learning mindset and delivery focus to the Midtronics team.

Thank you again for your time and consideration. I look forward to your feedback!

Best regards,  
**Ricardo Ramos Olivares**  
riro9510@gmail.com | +52 922-1565872  
LinkedIn: https://www.linkedin.com/in/ricardo-ramos-olivares-201402217  
GitHub: https://github.com/riro9510