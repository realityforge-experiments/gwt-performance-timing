require 'buildr/single_intermediate_layout'
require 'buildr/git_auto_version'
require 'buildr/top_level_generate_dir'

desc 'GWT Browser Timing API integration'
define 'gwt-timing' do
  project.group = 'org.realityforge.gwt.timing'
  compile.options.source = '1.6'
  compile.options.target = '1.6'
  compile.options.lint = 'all'

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  define 'resource' do
    compile.with :gwt_user, :gwt_dev

    test.using :testng
    test.with :mockito

    package(:jar).include("#{_(:source, :main, :java)}/*")
    package(:sources)
  end
end
