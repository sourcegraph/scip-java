// See https://docusaurus.io/docs/site-config.html for all the possible
// site configuration options.

const repoUrl = "https://github.com/sourcegraph/lsif-java";
const baseUrl = "/lsif-java/";

const siteConfig = {
  title: "lsif-java",
  tagline: "Java indexer for the Language Server Index Format (LSIF)",
  url: "https://sourcegraph.github.io/lsif-java",
  baseUrl: baseUrl,

  // Used for publishing and more
  projectName: "sourcegraph",
  organizationName: "lsif-java",

  // algolia: {
  //   apiKey: "5791175eba35c6626d93ae96610a8ae9",
  //   indexName: "scalamenta_mdoc"
  // },

  // For no header links in the top nav bar -> headerLinks: [],
  headerLinks: [
    { doc: "installation", label: "Docs" },
    { href: repoUrl, label: "GitHub", external: true }
  ],

  // If you have users set above, you add it here:
  // users,

  /* path to images for header/footer */
  headerIcon: "img/lsif-java.png",
  footerIcon: "img/lsif-java.png",
  favicon: "img/favicon.ico",

  /* colors for website */
  colors: {
    primaryColor: "#664100",
    secondaryColor: "#763F00"
  },

  customDocsPath: "website/target/docs",

  stylesheets: [baseUrl + "css/custom.css"],

  // This copyright info is used in /core/Footer.js and blog rss/atom feeds.
  copyright: `Copyright © ${new Date().getFullYear()} lsif-java developers`,

  highlight: {
    // Highlight.js theme to use for syntax highlighting in code blocks
    theme: "github"
  },

  /* On page navigation for the current documentation page */
  onPageNav: "separate",

  /* Open Graph and Twitter card images */
  ogImage: "img/lsif-java.png",
  twitterImage: "img/lsif-java.png",

  editUrl: `${repoUrl}/edit/master/docs/`,

  repoUrl,
};

module.exports = siteConfig;
